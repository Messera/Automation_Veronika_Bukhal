package pageObjects.saucedemo.entity;

import lombok.Getter;
import lombok.ToString;
@Getter
@ToString
@lombok.Builder(builderClassName = "LoginBuilder", setterPrefix = "with", buildMethodName = "create")

public class LoginBuilderEnt {

    private String username;
    private String password;

        public static class LoginBuilder {
            public LoginBuilder() {
            }
        }

}

