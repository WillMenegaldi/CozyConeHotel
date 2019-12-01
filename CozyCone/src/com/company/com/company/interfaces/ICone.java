package com.company.com.company.interfaces;

import com.company.models.Cone;
import com.company.com.company.enums.ETipoCone;

public interface ICone {
    Cone reservarCone(ETipoCone ETipoCone);
}