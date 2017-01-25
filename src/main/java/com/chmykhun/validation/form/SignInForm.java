package com.chmykhun.validation.form;

import lombok.Data;

@Data
public class SignInForm {

    private String phoneNumber;
    private String password;

    private boolean valid;

    private String phoneNumberErrorMessage;
    private String passwordErrorMessage;

}
