package io.mbab.sda.groupproject.menu.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.mbab.sda.groupproject.entity.Cd;
import io.mbab.sda.groupproject.entity.TrackOnCd;
import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.CdRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

@RequiredArgsConstructor
public class CreateCdAction implements MenuAction {

  private final CustomScanner scanner;
  private final MenuActionContext ctx;
  private final CdRepository repository;

  @Override
  public void execute() throws JsonProcessingException {
    System.out.println("0) Przejdź do poprzedniego menu");
    System.out.println("Podaj nazwę zespołu:");

    var input = scanner.nextLine();

    if (pressedZero(input)) return;

    var builder = Cd.builder().bandName(input);

    System.out.println("Podaj nazwę albumu:");

    input = scanner.nextLine();

    if (pressedZero(input)) return;

    builder.albumName(input);

    System.out.println("Podaj datę utworzenia albumu");

    input = scanner.nextLine();

    if (pressedZero(input)) return;

    builder.albumDate(LocalDate.parse(input));
    var album = builder.tracksOnCd(new ArrayList<TrackOnCd>()).build();

    repository.create(album);
    ctx.use(MainAction.class).execute();
  }

  private boolean pressedZero(String input) throws JsonProcessingException {
    if (input.equals("0")) {
      ctx.use(MainAction.class).execute();
      return true;
    }
    return false;
  }
}
