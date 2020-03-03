import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestLog {

    @Test
    public void testlog() {
        log.debug("=====>debug");
        log.error("=====>error");
        log.info("=====>info");
        log.warn("=====>warn");
        log.trace("=====>trace");
    }
}
