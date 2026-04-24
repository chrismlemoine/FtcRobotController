package org.firstinspires.ftc.team00000.auto;

import com.pedropathing.geometry.Pose;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.*;
import com.pedropathing.paths.*;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.team00000.pedroPathing.Constants;

@Autonomous(name = "Unified Auto - Pedro", group = UnifiedAutoConfig.GROUP)
public class UnifiedPedroAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Follower follower = Constants.createFollower(hardwareMap);
        Pose startPose = new Pose(
                UnifiedAutoConfig.PEDRO_START_X,
                UnifiedAutoConfig.PEDRO_START_Y,
                UnifiedAutoConfig.PEDRO_START_HEADING
        );
        Pose endPose = new Pose(
                UnifiedAutoConfig.PEDRO_START_X + UnifiedAutoConfig.DISTANCE_IN,
                UnifiedAutoConfig.PEDRO_START_Y,
                UnifiedAutoConfig.PEDRO_START_HEADING
        );

        follower.setStartingPose(startPose);
        follower.update();

        PathChain outAndBack = follower.pathBuilder()
                .addPath(new BezierLine(startPose, endPose))
                .addPath(new BezierLine(endPose, startPose))
                .build();

        waitForStart();
        if (isStopRequested()) return;

        follower.followPath(outAndBack);
        while (opModeIsActive() && follower.isBusy()) {
            follower.update();
            telemetry.addData("x", follower.getPose().getX());
            telemetry.addData("y", follower.getPose().getY());
            telemetry.addData("heading", follower.getPose().getHeading());
            telemetry.update();
        }
    }
}
