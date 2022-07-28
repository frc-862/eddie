package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class IndexerControl extends CommandBase {
    DoubleSupplier power;
    Indexer indexer;

    public IndexerControl(Indexer indexer, DoubleSupplier power) {
        addRequirements(indexer);
        this.indexer = indexer;
        this.power = power;
    }

    @Override
    public void execute() {
        indexer.setPower(power.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        indexer.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
