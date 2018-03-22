import org.junit.Test
import org.springframework.boot.test.rule.OutputCapture
import spock.lang.Specification


class CaptureSpec extends Specification {
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void out() {
        System.out.print("hello");
        assertEquals(outputCapture.toString(), "hello");
    }

}