package io.mbab.sda.groupproject.menu.action;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface MenuAction {

  void execute() throws JsonProcessingException;
}
