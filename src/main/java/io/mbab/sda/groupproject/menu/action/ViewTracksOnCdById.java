package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.CdRepository;
import io.mbab.sda.groupproject.repository.TrackOnCdRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ViewTracksOnCdById implements MenuAction {

    private final CustomScanner scanner;
    private final MenuActionContext ctx;
    private final TrackOnCdRepository repository;
    private final CdRepository cdRepository;

    @Override
    public void execute() {
        System.out.println("Podaj id albumu:");

        var input = scanner.nextLine();

        if (pressedZero(input)) return;

        var tracks = repository.findByCdId(Integer.parseInt(input));

           tracks.forEach(System.out::println);
       }


    private boolean pressedZero(String input) {
        if (input.equals("0")) {
            ctx.use(MainAction.class).execute();
            return true;
        }
        return false;
    }
}