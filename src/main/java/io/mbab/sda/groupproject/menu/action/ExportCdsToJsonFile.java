package io.mbab.sda.groupproject.menu.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.CdRepository;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
public class ExportCdsToJsonFile implements MenuAction {

  private final MenuActionContext ctx;
  private final CdRepository repository;
  private final ObjectMapper objectMapper;

  @Override
  public void execute() {
    var cds = repository.getAll();

    if (cds.isEmpty()) {
      System.out.println("Brak danych do zapisania");
    } else {
      System.out.println("\n");

      ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
      try {
        ow.writeValue(new File("C:\\Users\\HP\\Desktop\\CDs.json"), cds);
      } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Export do pliku json nie powiódł się");
      }
      System.out.println("Export do pliku json zakończony powodzeniem");
    }

    ctx.use(MainAction.class).execute();
  }
}
