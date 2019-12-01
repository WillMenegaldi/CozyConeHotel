package com.company.com.company.interfaces;

import com.company.com.company.enums.ETipoCone;
import com.company.com.company.models.ConeComVaranda;
import com.company.com.company.abstracts.Cone;

public interface ICone
{
    Cone reservarCone(ETipoCone ETipoCone);
}