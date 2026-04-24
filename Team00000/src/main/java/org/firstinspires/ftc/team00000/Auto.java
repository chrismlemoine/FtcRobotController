package org.firstinspires.ftc.team00000;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Gyro", group = "A")
public class Auto extends LinearOpMode {
    Hardware robot = new Hardware(this);

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();

        while (opModeInInit()) {
            telemetry.addData("Robot Heading", "%4.0f", robot.getHeading());
            telemetry.update();
        }

    }
}
