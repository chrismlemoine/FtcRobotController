package org.firstinspires.ftc.team00000.pedroPathing;

import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegistrar;

import org.firstinspires.ftc.robotcore.internal.opmode.OpModeMeta;
import org.firstinspires.ftc.team00000.OpModeVisibility;

public final class PedroTuningRegistrar {
    private PedroTuningRegistrar() {}

    @OpModeRegistrar
    public static void register(OpModeManager manager) {
        if (!OpModeVisibility.ENABLE_PEDRO_TUNING) return;

        manager.register(
                new OpModeMeta.Builder()
                        .setName("Tuning")
                        .setGroup("Pedro Pathing")
                        .setFlavor(OpModeMeta.Flavor.TELEOP)
                        .build(),
                Tuning.class
        );
    }
}
