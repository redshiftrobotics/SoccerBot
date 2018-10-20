# Soccerbot

This repository contains the code for our Redshift Soccerbots, simple pushbots that we use for demos. We give Gamepad 1 to the visitor and have a team member hold Gamepad 2. Normally, Gamepad 1 drives the robot (tank drive), and Gamepad 2 does nothing. However, if either trigger is pulled on Gamepad 2, then "override mode" is enabled, which disables Gamepad 1 and allows Gamepad 2 to drive the robot.

Additionally, override mode disables the speed scalar that we usually use to prevent excessive crashing. (Our soccerbots are very fast.) It also allows the team member to adjust this speed scalar, using the bumpers of Gamepad 2.

## SDK Notes

This repository contains the source code for our Robot. It was forked from [the FTC SDK](https://github.com/ftctechnh/ftc_app). For more documentation on the SDK, please see the [FTC Wiki](https://github.com/ftctechnh/ftc_app/wiki). For more information on this repo, see [our wiki](https://github.com/redshiftrobotics/ftc_app/wiki), or contact [Ari Porad](https://github.com/ariporad) or [Zoe Carver](https://github.com/pudility).

## License

This project is licensed under the MIT License. See [LICENSE.md](license.md) for details. If you use it, please let us know!
