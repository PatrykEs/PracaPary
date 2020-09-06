package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MainAction implements MenuAction {

  private final CustomScanner scanner;
  private final MenuActionContext ctx;

  @Override
  public void execute() {
    System.out.println("0) Zamknij aplikację");
    System.out.println("1) Dodaj album");
    System.out.println("2) Wyswietl albumy");
    System.out.println("3) Dodaj utwór");
    System.out.println("4) Wyswietl utwory");
    System.out.println("5) Wyswietl album po id");
    System.out.println("6) Wyswietl utwory z albumu o podanym id");

    var input = scanner.nextLine();

    if (input.equals("0")) {
      System.exit(0);
      return;
    }

    if (input.equals("1")) {
      ctx.use(CreateCdAction.class).execute();
      return;
    }

    if (input.equals("2")) {
      ctx.use(ViewCdsAction.class).execute();
      return;
    }

    if (input.equals("3")) {
      ctx.use(CreateTrackOnCdAction.class).execute();
      return;
    }

    if (input.equals("4")) {
      ctx.use(ViewTracksOnCd.class).execute();
      return;
    }

    if (input.equals("5")) {
      ctx.use(FindCdById.class).execute();
      return;
    }

    if (input.equals("6")) {
      ctx.use(ViewTracksOnCdById.class).execute();
      return;
    }

    System.out.println("Wprowadzono nieprawidłowa wartość!");
    execute();
  }
}
