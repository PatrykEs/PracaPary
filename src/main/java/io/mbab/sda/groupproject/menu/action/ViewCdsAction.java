package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.CdRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ViewCdsAction implements MenuAction {

  private final MenuActionContext ctx;
  private final CdRepository repository;

  @Override
  public void execute() {
    var cds = repository.getAll();

    if (cds.isEmpty()) {
      System.out.println("Brak danych do wyświetlenia");
    } else {
      System.out.println("\n");
      cds.forEach(System.out::println);

      System.out.println("\n");
    }

    ctx.use(MainAction.class).execute();
  }
}
