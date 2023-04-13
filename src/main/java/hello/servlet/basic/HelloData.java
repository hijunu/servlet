package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter @Getter
public class HelloData {
    private String username;
    private int age;
}
