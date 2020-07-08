
package internal.nelbrecht.buildme;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

import static org.junit.jupiter.api.Assertions.fail;

public class SomeTest {

  @Test
  void good() {
  }

  @DisabledIfEnvironmentVariable(named = "NOBAD", matches = ".*")
  @Test
  void bad() {
    fail("bad");
  }

  @Disabled @Test
  void disabled() {
  }
}
