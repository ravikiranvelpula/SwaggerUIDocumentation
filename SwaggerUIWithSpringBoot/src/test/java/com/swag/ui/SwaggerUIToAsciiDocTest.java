package com.swag.ui;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.swag.ui.config.SwaggerConfig;

import io.github.swagger2markup.Swagger2MarkupConverter;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureRestDocs(outputDir = "build/asciidoc/snippets")
@SpringBootTest(classes = { SwagOfflineDocumentationApplication.class, SwaggerConfig.class })
@AutoConfigureMockMvc
public class SwaggerUIToAsciiDocTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void createSpringfoxSwaggerJson() throws Exception {
		// String designFirstSwaggerLocation =
		// Swagger2MarkupTest.class.getResource("/swagger.yaml").getPath();

		MvcResult mvcResult = this.mockMvc.perform(get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		MockHttpServletResponse response = mvcResult.getResponse();
		String swaggerJson = response.getContentAsString();
		// Files.write(Paths.get("build/swagger/swagger.json"),
		// swaggerJson.getBytes());
		Swagger2MarkupConverter.from(swaggerJson).build().toFolder(Paths.get("src/docs/asciidoc/generated"));

	}

}
