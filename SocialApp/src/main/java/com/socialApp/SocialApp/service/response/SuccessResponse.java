package com.socialApp.SocialApp.service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse extends  Response{
    private boolean status;
    private String message;
}
