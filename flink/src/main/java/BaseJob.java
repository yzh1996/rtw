import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.common.time.Time;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @ClassName: BaseJob
 * @Author: yzh
 * @Description:
 * @Date: 2022/4/23 20:07
 * @Version: 1.0
 */
public class BaseJob {

    public StreamExecutionEnvironment getDeafultEnv(){
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setRestartStrategy(RestartStrategies.fixedDelayRestart(3, Time.minutes(1)));
        env.getConfig().enableSysoutLogging();
        return env;
    }


}
