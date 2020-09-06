package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.entity.Cd;
import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.CdRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SearchCdByPerformerAction implements MenuAction {

    private final CustomScanner scanner;
    private final MenuActionContext ctx;
    private final CdRepository repository;

    @Override
    public void execute() {
        System.out.println("Podaj nazwę wykonawcy albumu:");

        var input = scanner.nextLine();

        if (pressedZero(input)) return;


        repository.findByBand(input).forEach(System.out::println);

        ctx.use(MainAction.class).execute();
    }

    private boolean pressedZero(String input) {
        if (input.equals("0")) {
            ctx.use(MainAction.class).execute();
            return true;
        }
        return false;
    }
}
