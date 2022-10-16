package madstodolist;

// imports

import madstodolist.model.Equipo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(scripts = "/clean-db.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class EquipoTest {

    @Test
    public void crearEquipo() {

    }
}