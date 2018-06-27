package com.cheney.springboot.oauth2;

import com.cheney.springboot.oauth2.utils.MD5Encoder;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.*;
import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test{


    private static final Logger logger=LoggerFactory.getLogger(test.class);
    @Test
    public void MD5Encode(){
        MD5Encoder encoder=new MD5Encoder();
        String en=encoder.MD5Encode("qwe123","");
        System.out.println(en);

        Md5PasswordEncoder encoder1=new Md5PasswordEncoder();
        String en2=encoder1.encodePassword("qwe123","");
        System.out.println(en2);
    }
    @Test
    public void BlobEntity(){

    }
//    public static int blobUpdateForOracle(DataSource ds, String tableName, String filedName, String whereStr, OutputStreamWriter outputWriter)
//            throws SQLException {
//        if (logger.isDebugEnabled()) {
//            logger.debug("blobUpdateForOracle(String, String, String, String, byte[]) - start"); //$NON-NLS-1$
//        }
//
//        String selectSql = "select " + filedName + " from " + tableName + " where " + whereStr + " for update";
//        String updateSql = "UPDATE " + tableName + " SET " + filedName + "=EMPTY_BLOB() WHERE " + whereStr;
//        Statement stmt = null;
//        ResultSet rs = null;
//        int result = -1;
//        Connection cn = null;
//        try {
//            cn = ds.getConnection();
//            boolean defaultCommit = cn.getAutoCommit();
//            cn.setAutoCommit(false);
//            stmt = cn.createStatement();
//            result = stmt.executeUpdate(updateSql);
//            rs = stmt.executeQuery(selectSql);
//            while (rs.next()) {
//                BufferedOutputStream out = null;
//                try {
//                    Blob blob = rs.getBlob(1);
//                    out = new BufferedOutputStream(blob.setBinaryStream(1));
//                    outputWriter.write(out);
//                    try {
//                        out.close();
//                    } catch (Exception e) {
//                        logger.warn("blobUpdateForOracle:out.close", e);
//                    }
//                    cn.commit();
//                } catch (Exception e) {
//                    cn.rollback();
//                    logger.warn("blobUpdateForOracle:", e);
//                    throw new SQLException("更新失败:" + e.getMessage());
//                } finally {
//                    if (out != null) {
//                        try {
//                            out.close();
//                        } catch (Exception e) {
//                            // logger.warn("blobUpdateForOracle:out.close", e);
//                        }
//                    }
//                }
//            }
//            cn.setAutoCommit(defaultCommit);
//        } catch (Exception e) {
//            logger.warn("blobUpdateForOracle:" + whereStr, e);
//            throw new SQLException("更新失败:" + e.getMessage());
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (Exception e) {
//                    logger.error("blobUpdateForOracle", e);
//                }
//            }
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (Exception e) {
//                    logger.error("blobUpdateForOracle", e);
//                }
//            }
//            if (cn != null) {
//                try {
//                    cn.close();
//                } catch (Exception e) {
//                    logger.error("blobUpdateForOracle", e);
//                }
//            }
//        }
//
//        if (logger.isDebugEnabled()) {
//            logger.debug("blobUpdateForOracle(String, String, String, String, byte[]) - end"); //$NON-NLS-1$
//        }
//        return result;
//    }
//    /**
//     * oracle中導入模板
//     *
//     * @param tableName
//     * @param filedName
//     * @param id
//     * @param t
//     * @throws SQLException
//     */
//    public static int blobUpdateForOracle(DataSource ds, String tableName, String filedName, String whereStr, final InputStream in) throws SQLException {
//        return blobUpdateForOracle(ds, tableName, filedName, whereStr, new OutputStreamWriter() {
//            public void write(OutputStream outputStream) throws IOException {
//                IOUtils.copy(in, outputStream);
//            }
//        });
//    }
}