package spring.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Validated
@Configuration
@ConfigurationProperties(prefix = "owner")
public class OwnerConfigProperties {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Pattern(regexp = "^.*@.*\\.com|net|org|info$")
    private String mail;
}
