package com.example.jackson.springjpajackson;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
public class UserTest {

    @Test
    public void json_view_to_serialize() throws Exception {
        User user = new User(1, "Suck", "Normal life.");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

        String result = mapper.writerWithView(Views.Public.class)
                .writeValueAsString(user);

        assertThat(result, containsString("Suck"));
        assertThat(result, containsString("Normal life."));
        assertThat(result, not(containsString("1")));

    }

    @Test
    public void json_view_private_to_serialize() throws Exception {
        User user = new User(1, "Suck", "Normal life.");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

        String result = mapper.writerWithView(Views.Private.class)
                .writeValueAsString(user);

        assertThat(result, containsString("1"));
        assertThat(result, not(containsString("Suck")));
        assertThat(result, not(containsString("Normal life.")));

    }
}
