package com.example.Backend;

import java.time.LocalTime;

import com.github.lgooddatepicker.optionalusertools.PickerUtilities;
import com.github.lgooddatepicker.optionalusertools.TimeVetoPolicy;

public class TesteVeto implements TimeVetoPolicy {

    public TesteVeto() {

    }

    LocalTime startTime, endTime;

    public TesteVeto(LocalTime horaInicial, LocalTime horaFinal) {
        this.startTime = horaInicial;
        this.endTime = horaFinal;
    }

    @Override
    public boolean isTimeAllowed(LocalTime arg0) {
        // TODO Auto-generated method stub
        return PickerUtilities.isLocalTimeInRange(arg0, startTime, endTime, true);

    }

}
