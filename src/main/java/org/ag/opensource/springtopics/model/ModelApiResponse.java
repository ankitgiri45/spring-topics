package org.ag.opensource.springtopics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * ModelApiResponse
 */

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ModelApiResponse<T> {

  /**
   * APIResponse code
   */
  @NotNull
  @Schema(name = "code", example = "200", description = "APIResponse code", requiredMode = Schema.RequiredMode.REQUIRED)
  private final Integer code;


  /**
   * APIResponse message
   */
  @NotNull
  @Schema(name = "message", example = "Not found", description = "APIResponse message", requiredMode = Schema.RequiredMode.REQUIRED)
  private final String message;


  /**
   * APIResponse data
   */
  @Valid
  @Schema(name = "data", example = "{\"id\":1,\"name\":\"John Doe\",\"age\":25,\"department\":\"IT\"}", description = "APIResponse data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  private T data;

}

