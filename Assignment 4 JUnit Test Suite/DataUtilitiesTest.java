package org.jfree.data;

import static org.junit.Assert.*;

//import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {

	private Mockery mockingContext;
	private Mockery mockingContexts;
	private Values2D values;
	private KeyedValues keyedValues;
    private double[] data;
    private double[][] data2D;

	
	@Before
	public void setUp() {
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
    }
	
	@Before
	public void setUp1() {
        mockingContexts = new Mockery();
        keyedValues = mockingContexts.mock(KeyedValues.class);
    }
	
	
	
	
	// Test cases for calculateColumnTotal()
	
	/*
	 * this test case test for the correct output of two values in the column being added
	 */
	 @Test
	 public void calculateColumnTotalForTwoValues() {
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(result, 10.0, .000000001d);
	 }
	 
		/*
		 * this test case test for the correct output of positive values in the column being added
		 */	 
	    @Test
	    public void calculateColumnTotal_positiveValues() {
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(1000));
	                one(values).getValue(1, 0);
	                will(returnValue(100000));
	                one(values).getValue(2, 0);
	                will(returnValue(100000000));
	            }
	        });
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        assertEquals(100101000, result, 0.0000001d);
	    }

	    
		/*
		 * this test case test for the correct output of negative values in the column being added
		 */	
	    @Test
	    public void calculateColumnTotal_negativeValues() {
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(-1000));
	                one(values).getValue(1, 0);
	                will(returnValue(-100000));
	                one(values).getValue(2, 0);
	                will(returnValue(-100000000));
	            }
	        });
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        assertEquals(-100101000, result, 0.0000001d);
	    }
	    
	    
		/*
		 * this test case test for the correct output of mixed values in the column being added
		 */	
	    @Test
	    public void calculateColumnTotal_mixedValues() {
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(4));
	                one(values).getValue(0, 0);
	                will(returnValue(-1000));
	                one(values).getValue(1, 0);
	                will(returnValue(2000));
	                one(values).getValue(2, 0);
	                will(returnValue(-3000));
	                one(values).getValue(3, 0);
	                will(returnValue(4000));
	            }
	        });
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        assertEquals(2000, result, 0.0000001d);
	    }

	    
		/*
		 * this test case test for the correct output of zeros in the column being added
		 */	
	    @Test
	    public void calculateColumnTotal_zeroValues() {
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(0));
	                one(values).getValue(1, 0);
	                will(returnValue(0));
	                one(values).getValue(2, 0);
	                will(returnValue(0));
	            }
	        });
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        assertEquals(0.0, result, 0.0000001d);
	    }

	    
		/*
		 * this test case test for the correct output if there was a single value in the column
		 */	
	    @Test
	    public void calculateColumnTotal_singleValue() {
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(1));
	                one(values).getValue(0, 0);
	                will(returnValue(42));
	            }
	        });
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        assertEquals(42, result, 0.0000001d);
	    }

	    
		/*
		 * this test case test for the correct output if there were no values in the column
		 */	
	    @Test
	    public void calculateColumnTotal_emptyValues2D() {
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(0));
	            }
	        });
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        assertEquals(0.0, result, 0.0000001d);
	    }


		/*
		 * this test case test for the correct output of NaN in the column being added
		 */	
	    @Test
	    public void calculateColumnTotal_NaNValues() {
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(2));
	                one(values).getValue(0, 0);
	                will(returnValue(Double.NaN));
	                one(values).getValue(1, 0);
	                will(returnValue(Double.NaN));
	            }
	        });
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        assertTrue(Double.isNaN(result));
	    }

	    
		/*
		 * this test case test for the correct output of large values in the column being added
		 */	
	    @Test
	    public void calculateColumnTotal_largeValues() {
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(1.0e20));
	                one(values).getValue(1, 0);
	                will(returnValue(2.0e20));
	                one(values).getValue(2, 0);
	                will(returnValue(0.0));
	            }
	        });
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        assertEquals(3.0e20, result, 0.0000001d);
	    }

	    
		/*
		 * this test case test for the correct output of large values in the column being added
		 */	
	    @Test
	    public void calculateColumnTotal_infinityValues() {
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(2));
	                one(values).getValue(0, 0);
	                will(returnValue(Double.POSITIVE_INFINITY));
	                one(values).getValue(1, 0);
	                will(returnValue(Double.POSITIVE_INFINITY));
	            }
	        });
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        assertTrue(Double.isInfinite(result));
	    }

	    
	    
		
	    
// ------------------------------------------------------------------------------------------------
	   
	    
	    // Tests for the function calculateRowTotal
	    
	    
	    /*
		 * The test case checks the row total for only one value
		 */	 
	    
		 @Test
		 public void calculateRowTotalForOneValue() {
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getColumnCount();
		             will(returnValue(1));
		             one(values).getValue(0, 0);
		             will(returnValue(3.4));
		         }
		     });
		     double result = DataUtilities.calculateRowTotal(values, 0);
		     assertEquals("Unexpected result for calculateRowTotal", 3.4, result, .000000001d);
		 }


		 /*
			 * The test case checks the row total for two values
			 */	 
		 @Test
		 public void calculateRowTotalForTwoValues() {
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getColumnCount();
		             will(returnValue(2));
		             one(values).getValue(0, 0);
		             will(returnValue(6.5));
		             one(values).getValue(0, 1);
		             will(returnValue(3.5));
		         }
		     });
		     double result = DataUtilities.calculateRowTotal(values, 0);
		     assertEquals("Unexpected result for calculateRowTotal", 10.0, result, .000000001d);
		 }
		 
		 @Test
		 public void calculateRowTotalForEmpty() {
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getColumnCount();
		             will(returnValue(0));
		         }
		     });
		     double result = DataUtilities.calculateRowTotal(values, 0);
		     assertEquals("Unexpected result for calculateRowTotal", 0, result, .000000001d);
		 }
		 
		 /*
			 * The test case checks the row total for Five values
			 */	 

		 @Test
		 public void calculateRowTotalForFiveValues() {
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getColumnCount();
		             will(returnValue(5));
		             one(values).getValue(0, 0);
		             will(returnValue(8.0));
		             one(values).getValue(0, 1);
		             will(returnValue(2.0));
		             one(values).getValue(0, 2);
		             will(returnValue(5.5));
		             one(values).getValue(0, 3);
		             will(returnValue(4.5));
		             one(values).getValue(0, 4);
		             will(returnValue(1.1));


		         }
		     });
		     double result = DataUtilities.calculateRowTotal(values, 0);
		     assertEquals("Unexpected result for calculateRowTotal", 21.1, result, .000000001d);
		 }
		 
		 /*
			 * The test case checks to see what happens when given and out of bounds index
			 */	 


// ------------------------------------------------------------------------------------------------

	// Tests for create number array 
		 
		    // test for creating number array with a null value for double array
		 @Test
		 public void createNumberArrayWithNullInput() {
		        try {
		            DataUtilities.createNumberArray(null);
		            fail("Expected InvalidParameterException to be thrown");
		        } catch (IllegalArgumentException e) {
		            assertEquals("Null 'data' argument.", e.getMessage());
		        }
		    }

		 // test for creating number array with an empty double array
		 @Test
		 public void createNumberArrayEmpty() {
			 data = new double[0]; // Empty 2D array
		     Number[] result = DataUtilities.createNumberArray(data);
		     assertEquals("Expected an empty array", 0, result.length);
		 }
		 
		 // test for creating number array with an  double array of size 4
		 @Test
		 public void createNumberArraySize4() {
		     data = new double[]{1.0, 2.5, 3.7, 4.2}; 
		     Number[] result = DataUtilities.createNumberArray(data);
		     assertEquals("Expected array size 4", 4, result.length);
		 }
		 
		 // test for creating number array with an  double array of size 4 and using negative numbers
		 @Test
		 public void createNumberArraySize4_NegativeNumbers() {
		     data = new double[]{-1.0, -2.5, -3.7, -4.2}; 
		     Number[] result = DataUtilities.createNumberArray(data);
		     assertEquals("Expected array size 4", 4, result.length);
		 }
		 
		 
		 
		 // test for checking if any entry in the Number array is null
		 @Test
		 public void createNumberArray_NullEntryCheck() {
		     data = new double[]{1.0, 2.5, 3.7, 4.2}; 
		     Number[] result = DataUtilities.createNumberArray(data);
		     assertEquals("Expected array size 4", 4, result.length);

		     for (int i = 0; i < result.length; i++) {
		         assertNotNull("Element at index " + i + " is null", result[i]); // Check for null values
		     }
		 }
		 
		 // test for checking if the numbers in the Number array are correct
		 @Test
		 public void createNumberArray_CheckNumbers() {
		     data = new double[]{1.0, 2.5, 3.7, 4.2}; 
		     Number[] result = DataUtilities.createNumberArray(data);
		     assertEquals("Expected array size 4", 4, result.length);

		     for (int i = 0; i < result.length; i++) {
		         assertNotNull("Element at index " + i + " is null", result[i]); // Check for null values
		         assertEquals("Expected element at index " + i + " to match", data[i], result[i].doubleValue(), 0.000001);
		     }
		 }
		 
		 // test for checking if each element is of instance Number
		 @Test
		 public void createNumberArray_CreatesNumberObject() {
		     data = new double[]{1.0, 2.5, 3.7, 4.2}; 
		     Number[] result = DataUtilities.createNumberArray(data);
		     assertEquals("Expected array size 4", 4, result.length);
		     for (int i = 0; i < result.length; i++) {
		         assertTrue("Element at index " + i + " is not a Number object", result[i] instanceof Number); // Check if it's a Number object
		     }
		 }
		 

		 
// ------------------------------------------------------------------------------------------------

		 // Tests for createNumberArray2D
		 
		 // test to check for error message if function is called with a null vlaue
		    @Test
		    public void createNumberArray2DWithNullInput() {
		        try {
		            DataUtilities.createNumberArray2D(null);
		            fail("Expected InvalidParameterException to be thrown");
		        } catch (IllegalArgumentException e) {
		            assertEquals("Null 'data' argument.", e.getMessage());
		        }
		    }
		 
		 // test to check array size with an empty array
		    @Test
			 public void createNumberArray2DEmpty() {
				 data = new double[0];
				 Number[] result = DataUtilities.createNumberArray(data);
				    assertEquals("Expected an empty array", 0, result.length);
				 
		 	 }
			 
			 // test to check row size number for a 2x3 array
		    @Test
		    public void createNumberArray2DSize2x3_RowNumber() {
		        data2D = new double[][]{{-11.0, -2.0, -3.0}, {4.0, 5.0, 6.0}};
		        Number[][] result = DataUtilities.createNumberArray2D(data2D);
		        assertEquals("Expected array to have 2 rows", 2, result.length);
		    }
		    
		    // test to check column size for a 2x3 array
		    @Test
		    public void createNumberArray2DSize2x3_ColumnNumber() {
		        data2D = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
		        Number[][] result = DataUtilities.createNumberArray2D(data2D);
		        assertEquals("Expected each row to have 3 columns", 3, result[0].length);
		        assertEquals("Expected each row to have 3 columns", 3, result[1].length);
		    }
		    
		    // test to check for any null rows 
		    @Test
		    public void createNumberArray2DSize2x3_NullRows() {
		        data2D = new double[][]{{4.0, 6.0, 9.0}, {1.0, 2.0, 3.2}};

		        Number[][] result = DataUtilities.createNumberArray2D(data2D);

		        for (int i = 0; i < result.length; i++) {
		            assertNotNull("Expected row " + i + " not to be null", result[i]);
		        }
		    }
		    
		    // test to check for any null values in the first row
		    @Test
		    public void createNumberArray2DSize2x3_NullValues_RowZero() {
		        data2D = new double[][]{{4.0, 6.0, 9.0}, {1.0, 2.0, 3.2}};

		        Number[][] result = DataUtilities.createNumberArray2D(data2D);

		            for (int j = 0; j < result[0].length; j++) {
		                assertNotNull("Expected value at row " + 0 + ", column " + j + " not to be null", result[0][j]);
		            }
		        
		    }
		    // test to check for any null values in the second row
		    @Test
		    public void createNumberArray2DSize2x3_NullValues_RowOne() {
		        data2D = new double[][]{{4.0, 6.0, 9.0}, {1.0, 2.0, 3.2}};

		        Number[][] result = DataUtilities.createNumberArray2D(data2D);

		            for (int j = 0; j < result[1].length; j++) {
		                assertNotNull("Expected value at row " + 1 + ", column " + j + " not to be null", result[1][j]);
		            }
		        
		    }
		    
		    // test to check the values of each number in the new array
		    @Test
		    public void createNumberArray2DSize2x2_CheckNumbers() {
		        data2D = new double[][]{{4.0, 6.0}, {1.0, 3.2}};

		        Number[][] result = DataUtilities.createNumberArray2D(data2D);
		        assertNotNull("Expected value at row 0, column 0 was null", result[0][0]);
		        assertEquals("Expected value at row 0, column 0", 4.0, result[0][0].doubleValue(), 0.0001);
		        
		        assertNotNull("Expected value at row 0, column 0 was null", result[0][1]);
		        assertEquals("Expected value at row 0, column 1", 6.0, result[0][1].doubleValue(), 0.0001);
		        
		        assertNotNull("Expected value at row 0, column 0 was null", result[1][0]);
		        assertEquals("Expected value at row 1, column 0", 1.0, result[1][0].doubleValue(), 0.0001);
		        
		        assertNotNull("Expected value at row 0, column 0 was null", result[1][1]);
		        assertEquals("Expected value at row 1, column 1", 3.2, result[1][1].doubleValue(), 0.0001);
			    }

	    
	    
// ------------------------------------------------------------------------------------------------

		// Test cases for getCumulativePercentages() 
	    
		/*
		 * this test case test for the correct output if valid values are used
		 */	
	    @Test
	    public void getCumulativePercentages_validKeysValues() {
	        mockingContexts.checking(new Expectations() {
	            {
	                allowing(keyedValues).getValue(0);
	                will(returnValue(5.0));

	                allowing(keyedValues).getKey(0);
	                will(returnValue("0"));

	                allowing(keyedValues).getValue(1);
	                will(returnValue(9.0));

	                allowing(keyedValues).getKey(1);
	                will(returnValue("1"));

	                allowing(keyedValues).getValue(2);
	                will(returnValue(2.0));

	                allowing(keyedValues).getKey(2);
	                will(returnValue("2"));

	                allowing(keyedValues).getItemCount();
	                will(returnValue(3));
	            }
	        });
	        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	        System.out.print(result);
	        assertEquals(0.3125, (Double) result.getValue("0"), 0.0000001d);
	        assertEquals(0.875, (Double) result.getValue("1"), 0.0000001d);
	        assertEquals(1.0, (Double) result.getValue("2"), 0.0000001d);
	    }

	    
		/*
		 * this test case test for the correct output if no values are used
		 */	
	    @Test
	    public void getCumulativePercentages_emptyData() {
	        mockingContexts.checking(new Expectations() {
	            {
	            	allowing(keyedValues).getItemCount();
	                will(returnValue(0));
	            }
	        });
	        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	        assertEquals(0, result.getItemCount());
	    }

	    
		/*
		 * this test case test for the correct output if a single value is used
		 */	
	    @Test
	    public void getCumulativePercentages_singleValue() {
	        mockingContexts.checking(new Expectations() {
	            {
	            	allowing(keyedValues).getItemCount();
	                will(returnValue(1));
	                allowing(keyedValues).getKey(0);
	                will(returnValue("0"));
	                allowing(keyedValues).getValue(0);
	                will(returnValue(10.0));
	            }
	        });
	        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	        assertEquals(1, result.getItemCount());
	        assertEquals(1.0, (Double) result.getValue("0"), 0.0000001d);
	    }


		/*
		 * this test case test for the correct output if negative values are used
		 */	
	    @Test
	    public void getCumulativePercentages_negativeValues() {
	        mockingContexts.checking(new Expectations() {
	            {
	            	allowing(keyedValues).getItemCount();
	                will(returnValue(3));
	                allowing(keyedValues).getKey(0);
	                will(returnValue("0"));
	                allowing(keyedValues).getValue(0);
	                will(returnValue(-5.0));
	                allowing(keyedValues).getKey(1);
	                will(returnValue("1"));
	                allowing(keyedValues).getValue(1);
	                will(returnValue(-9.0));
	                allowing(keyedValues).getKey(2);
	                will(returnValue("2"));
	                allowing(keyedValues).getValue(2);
	                will(returnValue(-2.0));
	            }
	        });
	        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	        assertEquals(0.3125, (Double) result.getValue("0"), 0.0000001d);
	        assertEquals(0.875, (Double) result.getValue("1"), 0.0000001d);
	        assertEquals(1.0, (Double) result.getValue("2"), 0.0000001d);
	    }
	    
	    
	    /*
		 * this test case test for the correct output if mixed values are used
		 */	
	    @Test
	    public void getCumulativePercentages_mixedValues() {
	        mockingContexts.checking(new Expectations() {
	            {
	                allowing(keyedValues).getItemCount();
	                will(returnValue(4));
	                allowing(keyedValues).getKey(0);
	                will(returnValue("0"));
	                allowing(keyedValues).getValue(0);
	                will(returnValue(5.0));
	                allowing(keyedValues).getKey(1);
	                will(returnValue("1"));
	                allowing(keyedValues).getValue(1);
	                will(returnValue(-3.0));
	                allowing(keyedValues).getKey(2);
	                will(returnValue("2"));
	                allowing(keyedValues).getValue(2);
	                will(returnValue(10.0));
	                allowing(keyedValues).getKey(3);
	                will(returnValue("3"));
	                allowing(keyedValues).getValue(3);
	                will(returnValue(-2.0));
	            }
	        });
	        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	        assertEquals(0.5, (Double) result.getValue("0"), 0.0000001d);
	        assertEquals(0.2, (Double) result.getValue("1"), 0.0000001d);
	        assertEquals(1.2, (Double) result.getValue("2"), 0.0000001d);
	        assertEquals(1.0, (Double) result.getValue("3"), 0.0000001d);
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
//	    ----------------------- NEW TESTS FOR A3 -----------------------------
	    
	    
	 // Test for checking equality of two null arrays. They should be considered equal.
	    @Test
	    public void testEqual_NullArrays() {
	        double[][] a = null;
	        double[][] b = null;
	        assertTrue(DataUtilities.equal(a, b));
	    }

	    // Test for checking inequality when the first array is null and the second array is not null.
	    @Test
	    public void testEqual_NullArrayA() {
	        double[][] a = null;
	        double[][] b = new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } };
	        assertFalse(DataUtilities.equal(a, b));
	    }

	    // Test for checking inequality when the second array is null and the first array is not null.
	    @Test
	    public void testEqual_NullArrayB() {
	        double[][] a = new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } };
	        double[][] b = null;
	        assertFalse(DataUtilities.equal(a, b));
	    }

	    // Test for checking inequality when arrays have different dimensions.
	    @Test
	    public void testEqual_DifferentDimensions() {
	        double[][] a = new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } };
	        double[][] b = new double[][] { { 1.0, 2.0, 3.0 }, { 4.0, 5.0, 6.0 } };
	        assertFalse(DataUtilities.equal(a, b));
	    }

	    // Test for checking inequality when arrays have different values.
	    @Test
	    public void testEqual_DifferentValues() {
	        double[][] a = new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } };
	        double[][] b = new double[][] { { 1.0, 2.0 }, { 3.0, 5.0 } };
	        assertFalse(DataUtilities.equal(a, b));
	    }

	    // Test for checking equality when arrays have same values.
	    @Test
	    public void testEqual_SameValues() {
	        double[][] a = new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 }, { 3.0, 4.0 } };
	        double[][] b = new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 }, { 3.0, 4.0 } };
	        assertTrue(DataUtilities.equal(a, b));
	    }

	    // Test for checking equality when arrays contain NaN values.
	    @Test
	    public void testEqual_NaNValues() {
	        double[][] a = new double[][] { { Double.NaN, 2.0 }, { 3.0, Double.NaN } };
	        double[][] b = new double[][] { { Double.NaN, 2.0 }, { 3.0, Double.NaN } };
	        assertTrue(DataUtilities.equal(a, b));
	    }

	    // Test for checking equality when arrays contain Infinity values.
	    @Test
	    public void testEqual_INFValues() {
	        double[][] a = new double[][] { { Double.POSITIVE_INFINITY, 2.0 }, { 3.0, Double.NEGATIVE_INFINITY } };
	        double[][] b = new double[][] { { Double.POSITIVE_INFINITY, 2.0 }, { 3.0, Double.NEGATIVE_INFINITY } };
	        assertTrue(DataUtilities.equal(a, b));
	    }

	    // Test for checking inequality when arrays have different lengths.
	    @Test
	    public void testDifferentLengthArrays() {
	        double[][] a = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
	        double[][] b = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}; // Array b has one more row
	        
	        boolean result = DataUtilities.equal(a, b);
	        
	        assertFalse("Arrays should not be equal", result);
	    }

	    
	    //negative difference, full negative 
	    
	    
	    @Test
	    public void calculateColumnTotalForTwoValues_ValidRows() {
	        // Testing the calculation of column total for two valid rows
	        int[] validRows = {0,1};
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(2));
	                one(values).getValue(0, 0);
	                will(returnValue(7.5));
	                one(values).getValue(1, 0);
	                will(returnValue(2.5));
	            }
	        });
	        double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
	        assertEquals(result, 10.0, .000000001d);
	    }

	    @Test
	    public void calculateRowTotalForTwoValues_ValidColums() {
	        // Testing the calculation of row total for two valid columns
	        int[] validColums = {0,1};
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getColumnCount();
	                will(returnValue(2));
	                one(values).getValue(0, 0);
	                will(returnValue(6.5));
	                one(values).getValue(0, 1);
	                will(returnValue(3.5));
	            }
	        });
	        double result = DataUtilities.calculateRowTotal(values, 0, validColums);
	        assertEquals("Unexpected result for calculateRowTotal", 10.0, result, .000000001d);
	    }

	    @Test
	    public void calculateRowTotalnegative_ValColums() {
	        // Testing the calculation of row total with negative valid columns
	        int[] validColums = {0,1};
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getColumnCount();
	                will(returnValue(-1));
	            }
	        });
	        double result = DataUtilities.calculateRowTotal(values, 0, validColums);
	        assertEquals("Unexpected result for calculateRowTotal", 0, result, .000000001d);
	    }

	    
	    
	    
	    
	    @Test
	    public void testCloneNotNull() {
	        // Testing that the clone method returns a non-null array
	        double[][] original = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
	        double[][] cloned = DataUtilities.clone(original);
	        assertNotNull(cloned);
	    }

	    @Test
	    public void testCloneDimensions() {
	        // Testing that cloned array has the same dimensions as the original array
	        double[][] original = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
	        double[][] cloned = DataUtilities.clone(original);
	        assertEquals(original.length, cloned.length);
	        for (int i = 0; i < original.length; i++) {
	            assertEquals(original[i].length, cloned[i].length);
	        }
	    }

	    @Test
	    public void testCloneValues() {
	        // Testing that cloned array has the same values as the original array
	        double[][] original = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
	        double[][] cloned = DataUtilities.clone(original);
	        for (int i = 0; i < original.length; i++) {
	            assertArrayEquals(original[i], cloned[i], 0.0);
	        }
	    }

	    @Test
	    public void testCloneIndependence() {
	        // Testing that changing a value in the original array doesn't affect the cloned array
	        double[][] original = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
	        double[][] cloned = DataUtilities.clone(original);
	        original[0][0] = 100.0;
	        assertNotEquals(original[0][0], cloned[0][0]);
	    }
	    
	    
	    
	    
	    
	    
	    
	// ---------------------- NEW MUTATION TESTS -----------------------------------
	    
	    
	    @Test
		//Tests the clone method with a 2D array with a null entry
		public void testCloneWithNullValues() {
	        double[][] original = {{1.0, 2.0, 3.0}, null};
			double[][] cloned = DataUtilities.clone(original);
			boolean result = DataUtilities.equal(original, cloned);
			assertTrue("Arrays should be equal", result);
		}
	    
	    @Test(expected = IllegalArgumentException.class)
	    public void testNullSourceArray() {
	        // Testing that clone method throws IllegalArgumentException if source array is null
	        double[][] original = null; // Source array is null
	        DataUtilities.clone(original);
	    }

	    

	    @Test(expected = IllegalArgumentException.class)
	    public void testNullDataParameter() {
	        // Testing that calculateColumnTotal throws IllegalArgumentException if data parameter is null
	        Values2D data = null; // Data parameter is null
	        DataUtilities.calculateColumnTotal(data, 0);
	    }
	    
	    @Test(expected = IllegalArgumentException.class)
	    public void testNullDataParameter_calculateColumnTotal() {
	        // Testing that calculateColumnTotal throws IllegalArgumentException if data parameter is null
	        Values2D data = null; // Data parameter is null
	        DataUtilities.calculateColumnTotal(data, 0, new int[0]); // Passing an empty array as validRows
	    }

	    
	    @Test(expected = IllegalArgumentException.class)
	    public void testNullDataParameter_calculateRowTotal() {
	        // Testing that calculateRowTotal throws IllegalArgumentException if data parameter is null
	        Values2D data = null; // Data parameter is null
	        DataUtilities.calculateRowTotal(data, 0);
	    }
	    
	    @Test(expected = IllegalArgumentException.class)
	    public void testNullDataParameter_calculateRowTotal_valid() {
	        // Testing that calculateRowTotal throws IllegalArgumentException if data parameter is null
	        Values2D data = null; // Data parameter is null
	        int[] validCols = new int[] {0, 1}; // Valid columns parameter
	        DataUtilities.calculateRowTotal(data, 0, validCols);
	    }
	    
	    @Test(expected = IllegalArgumentException.class)
	    public void testNullDataParameter_getCumulativePercentages() {
	        // Testing that getCumulativePercentages throws IllegalArgumentException if data parameter is null
	        KeyedValues data = null; // Data parameter is null
	        DataUtilities.getCumulativePercentages(data);
	    }
	    
	    
	    @Test
	    public void calculateColumnTotal_null() {
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(2));
	                one(values).getValue(0, 0);
	                will(returnValue(1));
	                one(values).getValue(1, 0);
	                will(returnValue(null));
	            }
	        });
	        
	        
	        
	        
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        assertEquals(1.0, result, 0.000001); // Use a small delta parameter (e.g., 0.000001) for comparison

	    }
	    
	    
	    
	    
	    @Test
	    public void calculateColumnTotal_null_valid() {
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(2));
	                one(values).getValue(0, 0);
	                will(returnValue(1));
	                one(values).getValue(1, 0);
	                will(returnValue(null));
	            }
	        });
	        
	        
	        
	        
		     int[] validRows = {0, 1}; // Assuming both rows are valid
	        double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
	        assertEquals(1.0, result, 0.000001); // Use a small delta parameter (e.g., 0.000001) for comparison

	    }
	    
	    
	    
		 @Test
		 public void calculateRowTotalForTwoValues_null() {
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getColumnCount();
		             will(returnValue(2));
		             one(values).getValue(0, 0);
		             will(returnValue(6.5));
		             one(values).getValue(0, 1);
		             will(returnValue(null));
		         }
		     });
		     double result = DataUtilities.calculateRowTotal(values, 0);
		     assertEquals("Unexpected result for calculateRowTotal", 6.5, result, .000000001d);
		 }


	    
	    
		 @Test
		 public void calculateRowTotalForTwoValues_null_valid() {
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getColumnCount();
		             will(returnValue(2));
		             one(values).getValue(0, 0);
		             will(returnValue(null));
		             one(values).getValue(0, 1);
		             will(returnValue(6.5));
		         }
		     });
		     int[] validCol = {0, 1}; // Assuming both rows are valid
		     double result = DataUtilities.calculateRowTotal(values, 0,validCol);
		     assertEquals("Unexpected result for calculateRowTotal", 6.5, result, .000000001d);
		 }

	    
	    
		 
		    @Test
		    public void testEqual_differntvalues() {
		        double[][] a = new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 }, { 3.0, 4.0 } };
		        double[][] b = new double[][] { { 2.0, 2.0 }, { 3.0, 4.0 }, { 3.0, 4.0 } };
		        assertFalse(DataUtilities.equal(a, b));
		    }
 
			 @Test
			 public void calculateColumnTotalForTwoValues_column_1() {
			     mockingContext.checking(new Expectations() {
			         {
			             one(values).getRowCount();
			             will(returnValue(2));
			             one(values).getColumnCount();
			             will(returnValue(2));
			             one(values).getValue(0, 1);
			             will(returnValue(7.5));
			             one(values).getValue(1, 1);
			             will(returnValue(2.5));
			         }
			     });
			     double result = DataUtilities.calculateColumnTotal(values, 1);
			     assertEquals(result, 10.0, .000000001d);
			 }
		    
	    	  
			 
			 
			 @Test
			 public void calculateColumnTotalForTwoValues_column_1_valid() {
			     mockingContext.checking(new Expectations() {
			         {
			             one(values).getRowCount();
			             will(returnValue(2));
			             one(values).getColumnCount();
			             will(returnValue(2));
			             one(values).getValue(0, 1);
			             will(returnValue(7.5));
			             one(values).getValue(1, 1);
			             will(returnValue(2.5));
			         }
			     });
			     int[] valid = {0,1};
			     double result = DataUtilities.calculateColumnTotal(values, 1,valid);
			     assertEquals(result, 10.0, .000000001d);
			 }
			 
			 @Test
			 public void calculateRowTotalForTwoValues_Row_1_valid() {
			     mockingContext.checking(new Expectations() {
			         {
			             one(values).getRowCount();
			             will(returnValue(2));
			             one(values).getColumnCount();
			             will(returnValue(2));
			             one(values).getValue(1, 0);
			             will(returnValue(7.5));
			             one(values).getValue(1, 1);
			             will(returnValue(2.5));
			         }
			     });
			     int[] valid = {0,1};
			     double result = DataUtilities.calculateRowTotal(values, 1,valid);
			     assertEquals(result, 10.0, .000000001d);
			 }
			 
			 
			 @Test
			 public void calculateRowTotalForTwoValues_row_1() {
			     mockingContext.checking(new Expectations() {
			         {
			             one(values).getRowCount();
			             will(returnValue(2));
			             one(values).getColumnCount();
			             will(returnValue(2));
			             one(values).getValue(1, 0);
			             will(returnValue(7.5));
			             one(values).getValue(1, 1);
			             will(returnValue(2.5));
			         }
			     });
			     double result = DataUtilities.calculateRowTotal(values, 1);
			     assertEquals(result, 10.0, .000000001d);
			 }
			 
			 
			 
			 @Test
			    public void calculateColumnTotalForThreeValues_but5entries_ValidRows() {
			        // Testing the calculation of column total for two valid rows
			        int[] validRows = {2};
			        mockingContext.checking(new Expectations() {
			            {
			                one(values).getRowCount();
			                will(returnValue(2));
			                one(values).getValue(2, 0);
			                will(returnValue(7.5));
			            }
			        });
			        double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
			        assertEquals(result, 0, .000000001d);
			    }

			    @Test
			    public void calculateRowTotalForinvalid() {
			        // Testing the calculation of row total for two valid columns
			        int[] validColums = {2};
			        mockingContext.checking(new Expectations() {
			            {
			                one(values).getColumnCount();
			                will(returnValue(2));
			                one(values).getValue(0, 2);
			                will(returnValue(6.5));
			            }
			        });
			        double result = DataUtilities.calculateRowTotal(values, 0, validColums);
			        assertEquals("Unexpected result for calculateRowTotal", 0, result, .000000001d);
			    }


}
