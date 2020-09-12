package io.mbab.sda.groupproject.menu.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.TrackOnCdRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ViewTracksOnCdAction implements MenuAction {

  private final MenuActionContext ctx;
  private final TrackOnCdRepository repository;

  @Override
  public void execute() throws JsonProcessingException {
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
