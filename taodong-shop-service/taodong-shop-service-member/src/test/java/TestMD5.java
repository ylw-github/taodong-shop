import com.ylw.common.core.util.MD5Util;
import org.junit.Test;

public class TestMD5 {

    @Test
    public void md5() {
        String enctryPwd = MD5Util.MD5("123");
        System.out.println("enctryPwd -> " + enctryPwd);
    }
}
