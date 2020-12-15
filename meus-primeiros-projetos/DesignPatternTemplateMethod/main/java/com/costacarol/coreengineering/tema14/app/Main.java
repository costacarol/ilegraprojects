package com.costacarol.coreengineering.tema14.app;

import com.costacarol.coreengineering.tema14.template.HotChocolate;
import com.costacarol.coreengineering.tema14.template.HotDrink;
import com.costacarol.coreengineering.tema14.template.Tea;

public class Main {
    public static void main(String[] args) {
    HotChocolate hotChocolate = new HotChocolate();
    hotChocolate.makeHotDrink();

    HotDrink tea = new Tea();
    tea.makeHotDrink();
    }
}
