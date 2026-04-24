package org.firstinspires.ftc.team00000.auto;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.team00000.roadRunner.MecanumDrive;

@Autonomous(name = "Unified Auto - Road Runner", group = UnifiedAutoConfig.GROUP)
public class UnifiedRoadRunnerAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d startPose = new Pose2d(
                UnifiedAutoConfig.RR_START_X,
                UnifiedAutoConfig.RR_START_Y,
                UnifiedAutoConfig.RR_START_HEADING
        );
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose);

        waitForStart();
        if (isStopRequested()) return;

        Actions.runBlocking(
                drive.actionBuilder(startPose)
                        .splineTo(
                                new Vector2d(UnifiedAutoConfig.RR_START_X + UnifiedAutoConfig.DISTANCE_IN,
                                        UnifiedAutoConfig.RR_START_Y),
                                UnifiedAutoConfig.RR_START_HEADING
                        )
                        .splineTo(
                                new Vector2d(UnifiedAutoConfig.RR_START_X, UnifiedAutoConfig.RR_START_Y),
                                UnifiedAutoConfig.RR_START_HEADING
                        )
                        .build()
        );
    }
}
