package com.derby.test.task.service.response;

import com.derby.test.task.model.DataModel;
import lombok.Data;

@Data
public class GetDataResponse {
    private DataModel   data;
    private String      response;
    private Long      request;

    public GetDataResponse(DataModel data, String response, Long request) {
        this.data = data;
        this.response = response;
        this.request = request;
    }
}
