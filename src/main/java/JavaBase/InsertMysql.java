package JavaBase; /**
 * @author 633805 LYH
 * @version V1.0
 * @description 插入百万数据到mysql
 * @update 2018/11/15
 * @since 1.7
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
* @Description:    java类作用描述
* @Author:         633805  LYH
* @CreateDate:     2019/4/2 9:33
* @UpdateUser:     luoyuhua
* @UpdateDate:     2019/4/2 10:33
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class InsertMysql {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final String url = "jdbc:mysql://127.0.0.1/test?useSSL=false&rewriteBatchedStatements=true" ;
        final String name = "com.mysql.jdbc.Driver" ;
        final String user = "root" ;
        final String password = "123456" ;
        Connection conn = null ;
        Class.forName(name); //指定连接类型
        conn = DriverManager.getConnection(url, user, password); //获取连接
        if (conn!= null ) {
            System.out.println( "获取连接成功" );
            insert(conn);
        } else {
            System.out.println( "获取连接失败" );
        }

    }
    public static void insert(Connection conn) {
        // 开始时间
        Long begin = System.currentTimeMillis();
        // sql前缀
        String prefix = "INSERT INTO t_teacher (t_name,t_password,sex,description,pic_url,school_name,regist_date,remark) VALUES " ;
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit( false );
            // 比起st，pst会更好些
            PreparedStatement  pst = (PreparedStatement) conn.prepareStatement( "" ); //准备执行语句
            // 外层循环，总提交事务次数
            for ( int i = 1 ; i <= 100 ; i++) {
                suffix = new StringBuffer();
                // 第j次提交步长
                for ( int j = 1 ; j <= 10000 ; j++) {
                    // 构建SQL后缀
                    suffix.append( " ( '" +i*j+ "','123456'" + ",'男'" + ",'教师'" + ",'www.bbk.com'" + ",'XX大学'" + ",'" + "2016-08-12 14:43:26" + "','备注'" + " ), " );
                }
                // 构建完整SQL
                String sql = prefix + suffix.substring( 0 , suffix.length() - 1 );
                // 添加执行SQL
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = System.currentTimeMillis();
        // 耗时
        System.out.println( "100万条数据插入花费时间 : " + (end - begin) / 1000 + " s" );
        System.out.println( "插入完成" );
    }
}
