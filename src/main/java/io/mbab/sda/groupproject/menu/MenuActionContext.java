package io.mbab.sda.groupproject.menu;

import io.mbab.sda.groupproject.menu.action.CreateCdAction;
import io.mbab.sda.groupproject.menu.action.MainAction;
import io.mbab.sda.groupproject.menu.action.MenuAction;
import io.mbab.sda.groupproject.menu.action.ViewCdsAction;
import io.mbab.sda.groupproject.repository.CdRepository;
import io.mbab.sda.groupproject.repository.CrudRepositoryFactory;
import lombok.SneakyThrows;

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
        ViewCdsAction.class,
        new ViewCdsAction(this, repositoryFactory.get(CdRepository.class)));
  }
}
