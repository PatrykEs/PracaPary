package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.entity.Cd;
import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.CdRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchCdAction implements MenuAction {

  private final CustomScanner scanner;
  private final MenuActionContext ctx;
  private final CdRepository repository;

  @Override
  public void execute() {
    System.out.println("Podaj id albumu:");

    var input = scanner.nextLine();

    if (pressedZero(input)) return;

    Cd cd = repository.findById(Integer.parseInt(input));
    System.out.println(cd);
  }

  private boolean pressedZero(String input) {
    if (input.equals("0")) {
      ctx.use(MainAction.class).execute();
      return true;
    }
    return false;
  }
}
