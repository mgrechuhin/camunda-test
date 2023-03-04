package io.m_arc.camunda.test;


import org.camunda.community.rest.client.api.DeploymentApi;
import org.camunda.community.rest.client.invoker.ApiClient;
import org.camunda.community.rest.client.invoker.ApiException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.Date;

@SpringBootTest(classes = CamundaInstanceTestApp.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DeploymentApiTest {
    private static ApiClient client = new ApiClient();
    private static DeploymentApi api = new DeploymentApi(client);

    @Test
    public void shouldCreateDeployment() throws Exception {
        String bpmnXmlPath = "processes/start_end.bpmn";
        api.createDeployment(
                null,
                null,
                true,
                true,
                "benchmark",
                null,
                new File(DeploymentApiTest.class.getClassLoader().getResource(bpmnXmlPath).getFile()));
    }
    @Test
    public void shouldGetDeployments() throws Exception {
        api.getDeployments(null, null, null, null, null, null, null, null, new Date(), null, null, null, null, null);
    }

    @Test
    public void shouldGetDeploymentsWithMessage() throws Exception {
        try {
            api.getDeployments(null, null, null, null, null, null, null, null, new Date(), null, null, null, null,
                    null);
        } catch (ApiException e) {
            throw new Exception(e.getResponseBody());
        }
    }
}
