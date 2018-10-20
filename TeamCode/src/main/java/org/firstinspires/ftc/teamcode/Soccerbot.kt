package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple

@TeleOp(name = "Soccerbot")
class Soccerbot(): OpMode() {
    private lateinit var leftDrive: DcMotor
    private lateinit var rightDrive: DcMotor

    private var visitorSpeedScalar = 0.5
    private val visitorSpeedScalarIncrement = 0.1

    private val override get() = gamepad2.left_trigger > 0.5 || gamepad2.right_trigger > 0.5

    private var lastLB = false
    private var lastRB = false

    override fun init() {
        leftDrive = hardwareMap.dcMotor.get("r1m0")!!.also { it.direction = DcMotorSimple.Direction.FORWARD }
        rightDrive = hardwareMap.dcMotor.get("r1m1")!!.also { it.direction = DcMotorSimple.Direction.REVERSE }

        telemetry.addLine("Soccerbot Initialized!")
        telemetry.addLine()
        telemetry.addLine("Press START to Begin")
        telemetry.update()
    }

    override fun loop() {
        if (override) {
            telemetry.addLine("""
                ---------------------------
                !!!!!! OVERRIDE MODE !!!!!!
                VISITOR DRIVING IS DISABLED
                Visitor Speed: ${visitorSpeedScalar}x
                (Use LB/RB to modify)
                ---------------------------
            """.trimIndent())
            leftDrive.power = gamepad2.left_stick_y.toDouble()
            rightDrive.power = gamepad2.right_stick_y.toDouble()

            if (gamepad2.left_bumper && !lastLB) visitorSpeedScalar -= visitorSpeedScalarIncrement
            if (gamepad2.right_bumper && !lastRB) visitorSpeedScalar += visitorSpeedScalarIncrement

            lastLB = gamepad1.left_bumper
            lastRB = gamepad1.right_bumper
        } else {
            telemetry.addLine("Welcome to Seattle Academy!")
            leftDrive.power = gamepad1.left_stick_y.toDouble() * visitorSpeedScalar
            rightDrive.power = gamepad1.right_stick_y.toDouble() * visitorSpeedScalar
        }

        telemetry.update()
    }
}