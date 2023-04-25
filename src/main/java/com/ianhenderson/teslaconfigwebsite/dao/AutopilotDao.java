package com.ianhenderson.teslaconfigwebsite.dao;

import com.ianhenderson.teslaconfigwebsite.model.Autopilot;

import java.util.List;

public interface AutopilotDao {
    Autopilot getAutopilot(int autopilotId);

    Autopilot getAutopilotName(String autopilotName);

    List<Autopilot> getAllAutopilotOptions();

    Autopilot createAutopilot(Autopilot newAutopilot);
}
