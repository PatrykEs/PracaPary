package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.entity.TrackOnCd;
import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.TrackOnCdRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTrackOnCdAction implements MenuAction {

    private final CustomScanner scanner;
    private final MenuActionContext ctx;
    private final TrackOnCdRepository repository;

    @Override
    public void execute() {
        System.out.println("0) Przejdź do poprzedniego menu");
        System.out.println("Podaj nazwę utworu:");

        var input = scanner.nextLine();

        if (pressedZero(input)) return;

        var builder = TrackOnCd.builder().trackName(input);

        System.out.println("Podaj czas trwania w sekundach:");

        input = scanner.nextLine();

        if (pressedZero(input)) return;

        var trackOnCd=  builder.trackTime(Integer.parseInt(input)).build();





        repository.create(trackOnCd);
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