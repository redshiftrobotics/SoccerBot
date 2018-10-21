package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple

@TeleOp(name = "Soccerbot")
class Soccerbot(): OpMode() {
    private lateinit var leftDrive: DcMotor
    private lateinit var rightDrive: DcMotor

    private val override get() = gamepad2.left_trigger > 0.5 || gamepad2.right_trigger > 0.5

    private var lastLB = false
    private var lastRB = false

    override fun init() {
        leftDrive = hardwareMap.dcMotor.get("left")!!.also { it.direction = DcMotorSimple.Direction.REVERSE }
        rightDrive = hardwareMap.dcMotor.get("right")!!.also { it.direction = DcMotorSimple.Direction.FORWARD }

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
                ---------------------------
            """.trimIndent())
            leftDrive.power = gamepad2.left_stick_y.toDouble()
            rightDrive.power = gamepad2.right_stick_y.toDouble()

            lastLB = gamepad1.left_bumper
            lastRB = gamepad1.right_bumper
        } else {
            telemetry.addLine("Welcome to Seattle Academy!")
            leftDrive.power = gamepad1.left_stick_y.toDouble()
            rightDrive.power = gamepad1.right_stick_y.toDouble()
        }

        telemetry.update()
    }
}