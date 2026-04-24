package org.firstinspires.ftc.team00000;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "FieldRelative", group = "A")
public class Teleop extends OpMode {
    Hardware robot = new Hardware(this);

    @Override
    public void init() {
        robot.init();
        telemetry.addLine("Status : Initialized");
    }

    @Override
    public void loop() {
        telemetry.addLine("A  : Reset Yaw");
        telemetry.addLine("LB : Robot-relative drive");
        telemetry.addLine("LS : Drive");
        telemetry.addLine("RS : Turn");

        if (gamepad1.a) {
            robot.resetYaw();
        }

        if (gamepad1.left_bumper) {
            robot.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        } else {
            robot.driveFieldRelative(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        }
    }
}
