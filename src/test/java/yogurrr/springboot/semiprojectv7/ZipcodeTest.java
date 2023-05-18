package yogurrr.springboot.semiprojectv7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yogurrr.springboot.semiprojectv7.model.Zipcode;
import yogurrr.springboot.semiprojectv7.repository.ZipcodeRepository;

import java.util.List;

@SpringBootTest
public class ZipcodeTest {

    @Autowired
    ZipcodeRepository zipcodeRepository;

    @Test
    @DisplayName("ZIPCODE")
    public void findZipByDong() {
        List<Zipcode> addr = zipcodeRepository.findZipcodeByDong("구로");

        System.out.println(addr);
    }
}
