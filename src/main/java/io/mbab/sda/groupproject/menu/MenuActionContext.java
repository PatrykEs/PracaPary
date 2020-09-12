package io.mbab.sda.groupproject.menu;


import io.mbab.sda.groupproject.menu.action.*;
import io.mbab.sda.groupproject.repository.CdRepository;
import io.mbab.sda.groupproject.repository.CrudRepositoryFactory;
import io.mbab.sda.groupproject.repository.TrackOnCdRepository;

import java.util.HashMap;
import java.util.Map;

public class MenuActionContext {

  private MenuAction action;
  private Map<Class<? extends MenuAction>, MenuAction> holder = new HashMap<>();

  public MenuActionContext(CustomScanner scanner, CrudRepositoryFactory repositoryFactory) {
    initHolder(scanner, repositoryFactory);
  }

  public MenuActionContext use(Class<? extends MenuAction> actionClass) {
    action = holder.get(actionClass);
    return this;
  }

  public void execute() {
    if (action == null) throw new RuntimeException("Menu action not set");
    action.execute();
  }

  private void initHolder(CustomScanner scanner, CrudRepositoryFactory repositoryFactory) {
    holder.put(MainAction.class, new MainAction(scanner, this));
    holder.put(
        CreateCdAction.class,
        new CreateCdAction(scanner, this, repositoryFactory.get(CdRepository.class)));
    holder.put(
        ViewCdsAction.class, new ViewCdsAction(this, repositoryFactory.get(CdRepository.class)));

    holder.put(
        CreateTrackOnCdAction.class,
        new CreateTrackOnCdAction(
            scanner,
            this,
            repositoryFactory.get(TrackOnCdRepository.class),
            repositoryFactory.get(CdRepository.class)));
    holder.put(
        ViewTracksOnCdAction.class,
        new ViewTracksOnCdAction(this, repositoryFactory.get(TrackOnCdRepository.class)));

    holder.put(
        SearchCdByIdAction.class,
        new SearchCdByIdAction(scanner, this, repositoryFactory.get(CdRepository.class)));

    holder.put(
        ViewTracksOnCdByIdAction.class,
        new ViewTracksOnCdByIdAction(
            scanner,
            this,
            repositoryFactory.get(TrackOnCdRepository.class),
            repositoryFactory.get(CdRepository.class)));

    holder.put(
        SearchCdByPerformerAction.class,
        new SearchCdByPerformerAction(scanner, this, repositoryFactory.get(CdRepository.class)));

    holder.put(
        ExportCdsToJsonFile.class,
        new ExportCdsToJsonFile(this, repositoryFactory.get(CdRepository.class)));
  }
}
