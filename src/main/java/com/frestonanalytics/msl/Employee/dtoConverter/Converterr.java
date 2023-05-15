package com.frestonanalytics.msl.Employee.dtoConverter;

public interface Converterr <T,F>
{
    T convert(F from);
}