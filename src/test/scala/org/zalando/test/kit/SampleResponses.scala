package org.zalando.test.kit

import org.mockserver.model.HttpRequest.request
import org.mockserver.model.HttpResponse.response
import org.zalando.test.kit.service.MockServerTestService


trait SampleResponses {
  this: MockServerTestService =>

  def healthCheckRespondsWith(body: String): Unit =
    client
      .when(request.withPath("/health"))
      .respond(response.withBody(body))

  def expectResponseWithStatus(status: Int): Unit =
    client.when(request()).respond(response.withStatusCode(status))

}
