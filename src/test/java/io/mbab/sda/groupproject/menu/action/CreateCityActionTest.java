package io.mbab.sda.groupproject.menu.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.CdRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CreateCityActionTest {

    @Test
    void shouldExecuteMainAction() {
        //given
        var scanner = mock(CustomScanner.class);
        var actionCtx = mock(MenuActionContext.class);
        var repository = mock(CdRepository.class);
        var testedAction = new CreateCdAction(scanner, actionCtx, repository);

        when(scanner.nextLine()).thenReturn("0");
        when(actionCtx.use(MainAction.class)).thenReturn(actionCtx);

        //when
        try {
            testedAction.execute();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //then
        try {
            verify(actionCtx, times(1)).use(MainAction.class).execute();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
