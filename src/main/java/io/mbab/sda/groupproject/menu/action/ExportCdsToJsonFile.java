package io.mbab.sda.groupproject.menu.action;

import com.fasterxml.jackson.core.JsonProcessingException;
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

  @Override
  public void execute() throws JsonProcessingException {
    var cds = repository.getAll();

    if (cds.isEmpty()) {
      System.out.println("Brak danych do zapisania");
    } else {
      System.out.println("\n");
      ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
      try {
        ow.writeValue(new File("C:\\Users\\HP\\Downloads\\PracaPary\\src\\CDs.json"), cds);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    ctx.use(MainAction.class).execute();
  }
}
