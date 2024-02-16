from django.shortcuts import render
from django.http import JsonResponse
from rest_framework.decorators import api_view
import json
# from keras.models import load_model
import tensorflow as tf
from sklearn.preprocessing import  MinMaxScaler,LabelEncoder
# Create your views here.
import numpy as np
def predict(data):
    
    loaded_model = tf.keras.models.load_model("/home/rahul/Cavista Hackathon/pred/my_model.keras")
    values = list(data.values())
    print(values)

    nparr = np.array(values,dtype=np.float64)
    reshaped_array = nparr.reshape(1, -1)
    print(reshaped_array)

    # tensor = tf.constant(values,  dtype=tf.float32)
    # tensor_reshaped = tf.reshape(tensor, shape=(11,))

    # print(result)
    # print(result)
    # print(type(values[0]))
    # print(reshaped_array)
    # scaler= MinMaxScaler()
    # x=scaler.fit_transform(reshaped_array)
    # print(x)

    normalizedData = (reshaped_array-np.min(reshaped_array))/(np.max(reshaped_array)-np.min(reshaped_array))
    print(normalizedData)
    ans = loaded_model.predict(normalizedData)

    ans = ans[0]
    return {"prediction": str(ans[0])   }

@api_view(['POST'])
def predict_post(request):

    if request.method == "POST": 
        json_data = json.loads(str(request.body, encoding='utf-8'))

        # print(json_data)

        response = predict(json_data)
        
        # print(json_data)
        # print(response)
        
        return JsonResponse(response,safe=True)
