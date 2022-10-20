package pageObjects.moodpanda.entity;

import lombok.*;

@Getter
@Setter
@Builder(builderClassName = "BuilderSignUp", setterPrefix = "with", buildMethodName = "create")
@AllArgsConstructor
@NoArgsConstructor
public class SignUpBuilder {

     String firstName;
     String lastName;
     String email;
     String password;
     Boolean checkbox;

    public static class BuilderSignUp {
        public BuilderSignUp() {
        }
    }




}
